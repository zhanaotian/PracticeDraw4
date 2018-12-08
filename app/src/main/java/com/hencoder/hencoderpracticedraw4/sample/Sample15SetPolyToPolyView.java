package com.hencoder.hencoderpracticedraw4.sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw4.R;

public class Sample15SetPolyToPolyView extends View {
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  Bitmap bitmap;
  Point point1 = new Point(200, 200);
  Matrix matrix = new Matrix();
  private float left = 0;
  private float top = 0;
  private float right = point1.x;
  private float bottom = point1.y;
  float[] pointsSrc = { left, top, right, top, left, bottom, right, bottom };
  float[] pointsDst = {
      left - 10, top + 30, right + 120, top - 90, left + 20, bottom + 30, right + 20, bottom + 60
  };

  public Sample15SetPolyToPolyView(Context context) {
    super(context);
  }

  public Sample15SetPolyToPolyView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Sample15SetPolyToPolyView(Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.save();
    matrix.reset();
    matrix.setPolyToPoly(pointsSrc, 0, pointsDst, 0, 4);
    canvas.concat(matrix);
    canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
    canvas.restore();
  }
}
