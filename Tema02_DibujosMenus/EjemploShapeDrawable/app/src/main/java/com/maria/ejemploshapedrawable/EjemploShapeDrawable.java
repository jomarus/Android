package com.maria.ejemploshapedrawable;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.View;

public class EjemploShapeDrawable extends Activity {

    public int x=20,y=20,ancho=300, alto=150;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new VistaAMedida(this));
    }

    public class VistaAMedida extends View {
        private ShapeDrawable miDrawable;

        //Start
        public VistaAMedida(Context contexto) {
            super(contexto);
            miDrawable = new ShapeDrawable(new OvalShape());
            miDrawable.getPaint().setColor(0xff0000ff);
            miDrawable.setBounds(x, y, x + ancho, y + alto);
        }

        //Update
        protected void onDraw(Canvas canvas) {

                miDrawable.draw(canvas);
                //invalidate();
           }
    }
}
