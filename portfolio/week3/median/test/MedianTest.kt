// COMP2850 Portfolio: Week 3
// Tests for median()

import io.kotest.core.spec.style.FreeSpec
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.floats.plusOrMinus

const val tolerance = 0.000001f

@Suppress("Unused")
class MedianTest : FreeSpec({

    "Exception when size=0" {
        shouldThrow<IllegalArgumentException> {
            median(listOf())
        }
    }

    "median of three numbers" {        //This checks 3 numbers that aren't in order can be correctly sorted and picks out the middle number with the median() function
        median(listOf(1, 3, 2)) shouldBe 2
    }

    "median of an even number of values" {         //this test lists an even number of values, which means there is no single middle value so it would return the average of the two middle numbers
        median(listOf(1, 2, 3, 4)) shouldBe 2.5
    }

    "median with duplicate values" {        //this test checks that the median function can handle duplicate values correctly
        median(listOf(2, 2, 5, 7, 7)) shouldBe 5
    }

    "median of a list in reverse order" {        //this test checks that the median function can handle a list that is in reverse order correctly
        median(listOf(5, 4, 3, 2, 1)) shouldBe 3
    }
})

