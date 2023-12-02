package esteban.g.twitter_searchesapp;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class ItemDivider extends RecyclerView.ItemDecoration{
    private final Drawable divider;
    public ItemDivider(Context context) {
        int[] attrs = {android.R.attr.listDivider};
        divider = context.obtainStyledAttributes(attrs).getDrawable(0);
    }
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent,
                           RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

         // calculate left/right x-coordinates for all dividers
         int left = parent.getPaddingLeft();
         int right = parent.getWidth() - parent.getPaddingRight();

         // for every item but the last, draw a line below it
         for (int i = 0; i < parent.getChildCount() - 1; ++i) {
             View item = parent.getChildAt(i); // get ith list item

             // calculate top/bottom y-coordinates for current divider
             int top = item.getBottom() + ((RecyclerView.LayoutParams)
                     item.getLayoutParams()).bottomMargin;
             int bottom = top + divider.getIntrinsicHeight();
             divider.setBounds(left, top, right, bottom);
             divider.draw(c);
         }
    }
}
