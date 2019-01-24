package com.android;

/**
 * Base class for interpolator
 */

abstract class Interpolator {
  static final int SPLINE = 0;
  static final int LINEAR = 1;

  public static Interpolator get(int type, double[] time, double[][] y) {
    if (type == SPLINE) {
      return new MonotoneSpline(time, y);
    }
    return new LinearInterpolator(time, y);

  }

  abstract void getPos(double t, double[] v);

  abstract void getPos(double t, float[] v);

  abstract double getPos(double t, int j);

  abstract void getSlope(double t, double[] v);

  abstract double getSlope(double t, int j);

  abstract double []getTimePoints();
}
