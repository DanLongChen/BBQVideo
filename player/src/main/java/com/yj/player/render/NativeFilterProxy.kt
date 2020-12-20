package com.yj.player.render

import com.yj.player.jni.FilterHelper

class NativeFilterProxy {
    private var nativeFilterHandle: Long = INIT_HANDLE

    fun setNativeFilterHandle(nativeFilterHandle: Long) {
        if (INIT_HANDLE == nativeFilterHandle) {
            throw RuntimeException("Native Filter handle is InValid")
        }
        this.nativeFilterHandle = nativeFilterHandle
    }

    fun getNativeFilterHandle(): Long {
        if (INIT_HANDLE == nativeFilterHandle) {
            throw RuntimeException("Native Filter handle is InValid")
        }
        return nativeFilterHandle
    }

    fun updatePreviewFrame(data: ByteArray?, format: Int, width: Int, height: Int) {
        if (NativeGLRenderProxy.INIT_HANDLE == nativeFilterHandle) {
            throw RuntimeException("Native Filter handle is InValid")
        }
        FilterHelper.updatePreviewFrame(nativeFilterHandle, data, format, width, height)
    }

    private fun destroyNativeFilterHandle() {
        if (NativeGLRenderProxy.INIT_HANDLE == nativeFilterHandle) {
            throw RuntimeException("Native Filter handle is InValid")
        }
        FilterHelper.destroyFilterHandle(nativeFilterHandle)
    }

    fun onDestroy() {
        destroyNativeFilterHandle()
    }

    companion object {
        const val INIT_HANDLE: Long = 0
    }
}