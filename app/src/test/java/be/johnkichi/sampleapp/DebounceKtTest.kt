package be.johnkichi.sampleapp

import be.johnkichi.sampleapp.databinding.debounce
import be.johnkichi.sampleapp.databinding.debounceUntilLast
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class DebounceKtTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Test
    fun `should call only once when time between calls is shorter than debounce delay`() =
        coroutineTestRule.testDispatcher.runBlockingTest {
            // given
            val debounceTime = 500L
            val timeBetweenCalls = 200L
            val firstParam = 1
            val secondParam = 2
            val testFun = mock<(Int) -> Unit> {
                onGeneric { invoke(any()) } doReturn Unit
            }
            val debounceTestFun = debounce(
                debounceTime,
                MainScope(),
                testFun
            )

            // when
            debounceTestFun(firstParam)
            advanceTimeBy(timeBetweenCalls)
            debounceTestFun(secondParam)

            // then
            verify(testFun, times(1)).invoke(any())
        }

    @Test
    fun `should call every time with proper params when times between calls is longer than debounce delay`() =
        coroutineTestRule.testDispatcher.runBlockingTest {
            // given
            val debounceTime = 500L
            val timeBetweenCalls = 1000L
            val firstParam = 1
            val secondParam = 2
            val testFun = mock<(Int) -> Unit> {
                onGeneric { invoke(any()) } doReturn Unit
            }
            val debounceTestFun = debounce(
                debounceTime,
                MainScope(),
                testFun
            )

            // when
            debounceTestFun(firstParam)
            advanceTimeBy(timeBetweenCalls)
            debounceTestFun(secondParam)

            // then
            verify(testFun).invoke(firstParam)
            verify(testFun).invoke(secondParam)
        }

    @Test
    fun `should wait for the last call when times between calls is shorter than debounce delay`() =
        coroutineTestRule.testDispatcher.runBlockingTest {
            // given
            val debounceTimeBeforeValidation = 500L
            val timeBetweenCalls = 200L
            val firstParam = 1
            val secondParam = 2
            val testFun = mock<(Int) -> Unit> {
                onGeneric { invoke(any()) } doReturn Unit
            }
            val debounceTestFun = debounceUntilLast(
                debounceTimeBeforeValidation,
                MainScope(),
                testFun
            )

            // when
            debounceTestFun(firstParam)
            advanceTimeBy(timeBetweenCalls)
            debounceTestFun(secondParam)
            advanceTimeBy(debounceTimeBeforeValidation)

            // then
            verify(testFun, times(0)).invoke(firstParam)
            verify(testFun, times(1)).invoke(secondParam)
        }

    @Test
    fun `should execute call after the debounce delay without waiting for further call`() =
        coroutineTestRule.testDispatcher.runBlockingTest {
            // given
            val debounceTimeBeforeValidation = 200L
            val timeBetweenCalls = 500L
            val firstParam = 1
            val secondParam = 2
            val testFun = mock<(Int) -> Unit> {
                onGeneric { invoke(any()) } doReturn Unit
            }
            val debounceTestFun = debounceUntilLast(
                debounceTimeBeforeValidation,
                MainScope(),
                testFun
            )

            // when
            debounceTestFun(firstParam)
            advanceTimeBy(timeBetweenCalls)
            debounceTestFun(secondParam)

            // then
            verify(testFun, times(1)).invoke(firstParam)
            verify(testFun, times(0)).invoke(secondParam)
        }
}
