package com.example.simplekeyboard // Reemplaza con tu nombre de paquete

import android.inputmethodservice.InputMethodService
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection

class MyKeyboardService : InputMethodService() {

    private lateinit var inputConnection: InputConnection

    override fun onCreateInputView(): View {
        val keyboardView = layoutInflater.inflate(R.layout.keyboard_layout, null)

        keyboardView.findViewById<View>(R.id.button_a).setOnClickListener {
            inputConnection.commitText("A", 1)
        }

        keyboardView.findViewById<View>(R.id.button_b).setOnClickListener {
            inputConnection.commitText("B", 1)
        }

        keyboardView.findViewById<View>(R.id.button_space).setOnClickListener {
            inputConnection.commitText(" ", 1)
        }

        return keyboardView
    }

    override fun onStartInput(attribute: EditorInfo?, restarting: Boolean) {
        super.onStartInput(attribute, restarting)
        inputConnection = currentInputConnection
    }
}