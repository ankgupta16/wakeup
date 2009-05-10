package edu.umich.gopalkri.wakeup;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

public class DestinationOverlay extends ItemizedOverlay<OverlayItem>
{
    private static OverlayItem currentItem = null;

    public static GeoPoint getSelectedLocation()
    {
        if (currentItem == null)
        {
            return null;
        }
        return currentItem.getPoint();
    }

    private Drawable mMarker;

    public DestinationOverlay(Drawable defaultMarker, GeoPoint gp, boolean reset)
    {
        super(defaultMarker);
        mMarker = defaultMarker;
        if (reset)
        {
            currentItem = null;
        }
        if (gp != null)
        {
            currentItem = new OverlayItem(gp, "", "");
        }
        populate();
    }

    /**
     * @see com.google.android.maps.ItemizedOverlay#draw(android.graphics.Canvas, com.google.android.maps.MapView, boolean)
     */
    @Override
    public void draw(Canvas canvas, MapView mapView, boolean shadow)
    {
        super.draw(canvas, mapView, shadow);
        boundCenterBottom(mMarker);
    }

    /**
     * @see com.google.android.maps.ItemizedOverlay#onTap(com.google.android.maps.GeoPoint, com.google.android.maps.MapView)
     */
    @Override
    public boolean onTap(GeoPoint p, MapView mapView)
    {
        super.onTap(p, mapView);

        currentItem = new OverlayItem(p, "", "");
        populate();

        return true;
    }

    @Override
    protected OverlayItem createItem(int arg0)
    {
        return currentItem;
    }

    @Override
    public int size()
    {
        if (currentItem == null)
        {
            return 0;
        }
        return 1;
    }
}
