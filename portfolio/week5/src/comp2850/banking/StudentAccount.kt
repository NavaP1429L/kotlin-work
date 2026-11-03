// COMP2850 Portfolio: Week 5
// StudentAccount class

package comp2850.banking

const val MAX_OVERDRAFT = 100

class StudentAccount(holder: String) : BankAccount(holder) {

    var overdraft = 0
        set(value) {
            if (value < 0 || value > MAX_OVERDRAFT) {
                throw IllegalArgumentException("Overdraft must be between 0 and 100")
            }
            field = value
        }

    override fun withdraw(amount: Int) {
        if (amount <= 0) {
            throw IllegalArgumentException("Withdrawal amount must be greater than 0")
        }

        if (balance - amount < -overdraft) {
            throw IllegalArgumentException("Insufficient funds for withdrawal")
        }

        balance -= amount
    }

    fun withdrawalsAllowed(): Boolean {
        return balance > -overdraft
    }

    override fun toString(): String {
        return "Account for $holder, balance = $balance (overdraft = $overdraft)"
    }
}