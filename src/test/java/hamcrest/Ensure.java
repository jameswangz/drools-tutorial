package hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matcher;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.hamcrest.core.IsSame;

public abstract class Ensure {

	public static void ensureThat(boolean matches) {
		ensureThat(matches, new IsSame<Boolean>(true));
	}

	public static <T> void ensureThat(T actual, Matcher<T> matcher) {
		assertThat(actual, matcher);
	}

	public static boolean not(boolean matches) {
		return !matches;
	}

	public static <T> Matcher<T> shouldBe(T expected) {
		return new IsEqual<T>(expected);
	}

	public static <T> Matcher<T> isNotNull() {
		return new IsNot<T>(new IsNull<T>());
	}

	public static <T> Matcher<T> isNull() {
		return new IsNull<T>();
	}

}
