package com.example.sample1

import android.app.AlertDialog
import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.dialog_input.view.*

class InputDialogFragment: DialogFragment() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        val view = View.inflate(context, R.layout.dialog_input, null)
        val builder = AlertDialog.Builder(context!!)
        builder.setView(view)
            .setNegativeButton(android.R.string.cancel, null)
            .setPositiveButton(R.string.resister) { _, _ ->
                Log.d("MY_LOG", "PUSHED REGISTER BUTTON")
                val step = view.editStep.text.toString()
                viewModel.inputStepCount.value = step.toInt()
            }
        return builder.create()
    }
}