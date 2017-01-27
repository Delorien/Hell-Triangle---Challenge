package com.b2w.challenge.test;

import com.b2w.challenge.HellTriangle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by CaLeo on 26/01/2017.
 */
@RunWith(Theories.class)
public class HellTriangleTest {

    private final static TriangleToTest sampleCase = new TriangleToTest("[[6],[3,5],[9,7,1],[4,6,8,4]]", 26);
    private final static TriangleToTest nearestsEqualsCase = new TriangleToTest("[[1],[2,2],[3,3,3],[4,4,4,4]]", 10);
    private final static TriangleToTest allZeroCase = new TriangleToTest("[[0],[0,0],[0,0,0],[0,0,0,0]]", 0);
    private final static TriangleToTest onlyOneLevelCase = new TriangleToTest("[[5]]", 5);
    private final static TriangleToTest manyLevelsCase = new TriangleToTest("[[1],[2,2],[3,3,3],[4,4,4,4],[5,5,5,5],[6,6,6,6],[7,7,7,7],[8,8,8,8],[9,9,9,9],[10,10,10,10]]", 55);

    @DataPoints
    public final static TriangleToTest[] triangles = {
            sampleCase,
            nearestsEqualsCase,
            allZeroCase,
            onlyOneLevelCase,
            manyLevelsCase,
    };

    @Theory
    public void getMaximumTotal_ReturnsExpectedTotal(TriangleToTest target) {
        HellTriangle hellTriangle = new HellTriangle(target.getHypotheticalTriangle());
        assertThat(hellTriangle.getMaximumTotal(), equalTo(target.expectedMaximumTotal));
    }

    @AllArgsConstructor
    protected static class TriangleToTest {

        private String hypotheticalTriangle;

        @Getter
        private int expectedMaximumTotal;

        public List<int[]> getHypotheticalTriangle() {
            return Pattern.compile("\\[\\[|[^\\d],[^\\d]|\\]\\]|[\\s]").splitAsStream(hypotheticalTriangle).filter(s -> !s.isEmpty()).
                    map(a -> Pattern.compile("\\D").splitAsStream(a).mapToInt(Integer::new).toArray()).collect(Collectors.toList());
        }
    }

}
