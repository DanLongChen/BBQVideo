package com.yj.player.render

import android.view.Surface
import com.yj.player.camera.Rotation
import com.yj.player.view.FilterType
import com.yj.player.jni.GLRenderHelper
import com.yj.player.view.RenderMode

class NativeGLRenderProxy {
    private var nativeGLRenderHandle: Long = INIT_HANDLE

    fun setNativeGLRenderHandle(nativeGLRenderHandle: Long) {
        if (INIT_HANDLE == nativeGLRenderHandle) {
            throw RuntimeException("Native GLRender handle is InValid")
        }
        this.nativeGLRenderHandle = nativeGLRenderHandle
    }

    private fun destroyNativeGLRenderHandle() {
        if (INIT_HANDLE == nativeGLRenderHandle) {
            throw RuntimeException("Native GLRender handle is InValid")
        }
        GLRenderHelper.destroyGLRenderHandle(nativeGLRenderHandle)
    }

    fun init() {
        if (INIT_HANDLE == nativeGLRenderHandle) {
            throw RuntimeException("Native GLRender handle is InValid")
        }
        GLRenderHelper.init(nativeGLRenderHandle)
    }

    fun unInit() {
        if (INIT_HANDLE == nativeGLRenderHandle) {
            throw RuntimeException("Native GLRender handle is InValid")
        }
        GLRenderHelper.unInit(nativeGLRenderHandle)
    }

    fun onPause() {
        if (INIT_HANDLE == nativeGLRenderHandle) {
            throw RuntimeException("Native GLRender handle is InValid")
        }
        GLRenderHelper.onPause(nativeGLRenderHandle)
    }

    fun onResume() {
        if (INIT_HANDLE == nativeGLRenderHandle) {
            throw RuntimeException("Native GLRender handle is InValid")
        }
        GLRenderHelper.onResume(nativeGLRenderHandle)
    }

    fun onAttachedToWindow() {
        if (INIT_HANDLE == nativeGLRenderHandle) {
            throw RuntimeException("Native GLRender handle is InValid")
        }
        GLRenderHelper.onAttachedToWindow(nativeGLRenderHandle)
    }

    fun onDetachedFromWindow() {
        if (INIT_HANDLE == nativeGLRenderHandle) {
            throw RuntimeException("Native GLRender handle is InValid")
        }
        GLRenderHelper.onDetachedFromWindow(nativeGLRenderHandle)
    }

    fun setNativeRotation(rotation: Rotation) {
        if (INIT_HANDLE == nativeGLRenderHandle) {
            throw RuntimeException("Native GLRender handle is InValid")
        }
        GLRenderHelper.setRotation(nativeGLRenderHandle, rotation)
    }

    fun setNativeRenderMode(renderMode: RenderMode) {
        if (INIT_HANDLE == nativeGLRenderHandle) {
            throw RuntimeException("Native GLRender handle is InValid")
        }
        if (renderMode == RenderMode.UNKNOWN) {
            throw RuntimeException("Render mode is InValid")
        }
        GLRenderHelper.setRenderMode(nativeGLRenderHandle, renderMode)
    }

    fun setNativeFilter(filterType: FilterType) {
        if (INIT_HANDLE == nativeGLRenderHandle) {
            throw RuntimeException("Native GLRender handle is InValid")
        }
        if (filterType == FilterType.UNKNOWN) {
            throw RuntimeException("Filter type is InValid")
        }
        GLRenderHelper.setFilter(nativeGLRenderHandle, filterType)
    }

    fun updatePreviewFrame(data: ByteArray?, format: Int, width: Int, height: Int) {
        if (INIT_HANDLE == nativeGLRenderHandle) {
            throw RuntimeException("Native GLRender handle is InValid")
        }
        GLRenderHelper.updatePreviewFrame(nativeGLRenderHandle, data, format, width, height)
    }

    fun requestRender() {
        if (INIT_HANDLE == nativeGLRenderHandle) {
            throw RuntimeException("Native GLRender handle is InValid")
        }
        GLRenderHelper.requestRender(nativeGLRenderHandle)
    }

    fun onSurfaceCreated(surface: Surface) {
        if (INIT_HANDLE == nativeGLRenderHandle) {
            throw RuntimeException("Native GLRender handle is InValid")
        }
        GLRenderHelper.onSurfaceCreated(nativeGLRenderHandle, surface)
    }

    fun onSurfaceChanged(surface: Surface, format: Int, width: Int, height: Int) {
        if (INIT_HANDLE == nativeGLRenderHandle) {
            throw RuntimeException("Native GLRender handle is InValid")
        }
        GLRenderHelper.onSurfaceChanged(nativeGLRenderHandle, surface, format, width, height)
    }

    fun onSurfaceDestroyed(surface: Surface) {
        if (INIT_HANDLE == nativeGLRenderHandle) {
            throw RuntimeException("Native GLRender handle is InValid")
        }
        GLRenderHelper.onSurfaceDestroyed(nativeGLRenderHandle, surface)
    }

    fun onDestroy() {
        destroyNativeGLRenderHandle()
    }

    companion object {
        const val INIT_HANDLE: Long = 0
    }
}