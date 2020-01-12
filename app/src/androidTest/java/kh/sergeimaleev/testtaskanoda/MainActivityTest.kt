package kh.sergeimaleev.testtaskanoda

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val appCompatImageButton = onView(
            allOf(
                withId(R.id.item_post_header_three_dots),
                childAtPosition(
                    allOf(
                        withId(R.id.item_post_header),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())

        val appCompatImageView = onView(
            allOf(
                withId(R.id.iv_like),
                childAtPosition(
                    allOf(
                        withId(R.id.post_bar),
                        childAtPosition(
                            withId(R.id.item_post_main),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageView.perform(click())

        val appCompatImageView2 = onView(
            allOf(
                withId(R.id.iv_comments),
                childAtPosition(
                    allOf(
                        withId(R.id.post_bar),
                        childAtPosition(
                            withId(R.id.item_post_main),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageView2.perform(click())

        val appCompatImageView3 = onView(
            allOf(
                withId(R.id.iv_share),
                childAtPosition(
                    allOf(
                        withId(R.id.post_bar),
                        childAtPosition(
                            withId(R.id.item_post_main),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatImageView3.perform(click())

        val appCompatImageView4 = onView(
            allOf(
                withId(R.id.iv_bookmark),
                childAtPosition(
                    allOf(
                        withId(R.id.post_bar),
                        childAtPosition(
                            withId(R.id.item_post_main),
                            1
                        )
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        appCompatImageView4.perform(click())

        val appCompatImageView5 = onView(
            allOf(
                withId(R.id.iv_like),
                childAtPosition(
                    allOf(
                        withId(R.id.post_bar),
                        childAtPosition(
                            withId(R.id.item_post_main),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageView5.perform(click())

        val appCompatImageView6 = onView(
            allOf(
                withId(R.id.iv_comments),
                childAtPosition(
                    allOf(
                        withId(R.id.post_bar),
                        childAtPosition(
                            withId(R.id.item_post_main),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageView6.perform(click())

        val appCompatImageView7 = onView(
            allOf(
                withId(R.id.iv_share),
                childAtPosition(
                    allOf(
                        withId(R.id.post_bar),
                        childAtPosition(
                            withId(R.id.item_post_main),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatImageView7.perform(click())

        val appCompatImageView8 = onView(
            allOf(
                withId(R.id.iv_bookmark),
                childAtPosition(
                    allOf(
                        withId(R.id.post_bar),
                        childAtPosition(
                            withId(R.id.item_post_main),
                            1
                        )
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        appCompatImageView8.perform(click())

        val appCompatImageButton2 = onView(
            allOf(
                withId(R.id.item_post_header_three_dots),
                childAtPosition(
                    allOf(
                        withId(R.id.item_post_header),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatImageButton2.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
