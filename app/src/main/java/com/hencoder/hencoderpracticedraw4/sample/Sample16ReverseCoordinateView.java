package com.hencoder.hencoderpracticedraw4.sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw4.R;

public class Sample16ReverseCoordinateView extends View {
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  Bitmap bitmap;
  Point point1 = new Point(200, 0);
  Point point2 = new Point(600, 0);

  public Sample16ReverseCoordinateView(Context context) {
    super(context);
  }

  public Sample16ReverseCoordinateView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Sample16ReverseCoordinateView(Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    int bitmapWidth = bitmap.getWidth();
    int bitmapHeight = bitmap.getHeight();
    canvas.save();
    canvas.translate(point1.x, point1.y);
    canvas.rotate(45, bitmapWidth / 2, bitmapHeight / 2);
    canvas.drawBitmap(bitmap, 0, 0, paint);
    canvas.restore();

    canvas.save();
    canvas.translate(point2.x, point2.y);
    canvas.rotate(45, bitmapWidth / 2, bitmapHeight / 2);
    canvas.drawBitmap(bitmap, 0, 0, paint);
    canvas.restore();
  }
}
