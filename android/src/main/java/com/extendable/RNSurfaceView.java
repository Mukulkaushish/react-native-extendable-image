package com.extendable;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Shahen on 7/6/17.
 */

public class RNSurfaceView extends GLSurfaceView implements GLSurfaceView.Renderer {
    public RNSurfaceView(Context context) {
        super(context);
        setCurrentInstanceAsRenderer();
    }

    public RNSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCurrentInstanceAsRenderer();
    }

    private void setCurrentInstanceAsRenderer() {
        setRenderer(this);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
        setEGLContextClientVersion(2);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }
}