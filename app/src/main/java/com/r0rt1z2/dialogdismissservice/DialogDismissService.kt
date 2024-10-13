package com.r0rt1z2.dialogdismissservice

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class DialogDismissService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED &&
                event.className?.contains("android.app.Dialog") == true
            && event.text.toString().contains(getString(R.string.app_suspended_title))
        ) {
            performGlobalAction(GLOBAL_ACTION_HOME)
        }
    }

    override fun onInterrupt() {
        // no-op
    }
}
