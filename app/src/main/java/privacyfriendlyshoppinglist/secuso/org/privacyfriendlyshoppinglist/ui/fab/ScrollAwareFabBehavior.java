package privacyfriendlyshoppinglist.secuso.org.privacyfriendlyshoppinglist.ui.fab;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Description: This class is used by the xml.
 * Source: https://guides.codepath.com/android/floating-action-buttons
 * Created: 16.07.16 creation date
 */
public class ScrollAwareFabBehavior extends FloatingActionButton.Behavior
{
    public ScrollAwareFabBehavior(Context context, AttributeSet attrs)
    {
        super();
    }

    @Override
    public boolean onStartNestedScroll(
            CoordinatorLayout coordinatorLayout,
            FloatingActionButton child,
            View directTargetChild,
            View target,
            int nestedScrollAxes)
    {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedScroll(
            CoordinatorLayout coordinatorLayout,
            FloatingActionButton child,
            View target,
            int dxConsumed,
            int dyConsumed,
            int dxUnconsumed,
            int dyUnconsumed)
    {
        if ( dyConsumed > 0 && child.getVisibility() == View.VISIBLE )
        {
            child.hide();
        }
        else if ( dyConsumed < 0 && child.getVisibility() != View.VISIBLE )
        {
            child.show();
        }
    }
}
