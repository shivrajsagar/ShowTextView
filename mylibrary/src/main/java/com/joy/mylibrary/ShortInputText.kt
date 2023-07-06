package com.joy.mylibrary

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.inputmethod.EditorInfo
import android.widget.EditText

@SuppressLint("AppCompatCustomView")
class ShortInputText(context: Context, attrs: AttributeSet) : EditText(context, attrs) {

    init {
        // Apply custom design modifications
        val drawable = ContextCompat.getDrawable(context, R.drawable.custom_background)
        background = drawable
        setTextColor(Color.RED)
    }

    override fun onTextChanged(text: CharSequence?, start: Int, lengthBefore: Int, lengthAfter: Int) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)

        // Perform actions when the text changes
        // For example, you can validate the input, show/hide error messages, etc.
        validateInput()
    }

    private fun validateInput() {
        val inputText = text.toString()

        // Perform your custom validation logic
        if (inputText.isEmpty()) {
            setError("Field cannot be empty")
        } else {
            setError(null)
        }
    }

    override fun onEditorAction(actionCode: Int) {
        super.onEditorAction(actionCode)

        // Perform actions when the user presses the "Done" or "Enter" button on the keyboard
        if (actionCode == EditorInfo.IME_ACTION_DONE) {
            // Do something, like saving the input or triggering an action
            saveInput()
        }
    }

    private fun saveInput() {
        val inputText = text.toString()

        // Save the input to a database or perform the desired action
        // For example:
        // Database.saveInput(inputText)
        // SomeAction.performAction(inputText)
    }
}