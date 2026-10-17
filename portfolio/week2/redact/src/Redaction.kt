// COMP2850 Portfolio: Week 2
// Function to redact sensitive information in a string
fun redact(
    document: String,
    text: String,
    redactionChar: Char = 'X'
): String {
    if (text.isEmpty()) {
        return document
    }

    val replacement = redactionChar.toString().repeat(text.length)

    return document.replace(text, replacement)
}