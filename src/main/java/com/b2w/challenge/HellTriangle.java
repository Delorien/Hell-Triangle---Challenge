package com.b2w.challenge;

import lombok.AllArgsConstructor;

import java.util.List;

/**
 * Created by Leonardo on 26/01/2017.
 */
@AllArgsConstructor
public class HellTriangle {

    private final List<int[]> triangle;

    public Integer getMaximumTotal() {

        int middle = 0;
        int maximumTotal = triangle.get(0)[middle];

        for (int i = 1; i < triangle.size(); i++) {
            int[] nextLevel = triangle.get(i);

            int left = middle - 1;
            int right = middle + 1;
            middle = getIndexOfBigger(nextLevel, left, right);
            maximumTotal = maximumTotal + nextLevel[middle];
        }

        return new Integer(maximumTotal);
    }

    private int getIndexOfBigger(int[] level, int left, int right) {
        int leftValue = getLeftValue(level, left);
        int rightValue = getRightValue(level, right);

        if (leftValue > rightValue) {
            return left;
        } else {
            return right;
        }
    }

    private int getLeftValue(int[] level, int left) {
        if (left < 0) {
            return 0;
        } else {
            return level[left];
        }
    }

    private int getRightValue(int[] level, int right) {
        if (right + 1 > level.length) {
            return 0;
        } else {
            return level[right];
        }
    }

}
