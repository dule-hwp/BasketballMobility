package com.rm.freedrawview;

import android.graphics.Path;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Riccardo on 22/11/16.
 */

public interface PathDrawnListener {

    void onPathStart();

    void onNewPathDrawn(ArrayList<Point> currentPathPoints);
}
