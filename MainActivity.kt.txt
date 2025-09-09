package com.acrossdeiiglobe.selfpromo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.acrossdeiiglobe.selfpromo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Declare binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Button click listener
        binding.buttonPreview.setOnClickListener {
            onPreviewClicked()
        }
        val spinnerValues: Array<String> = arrayOf("Android Developer", "Android Engineer")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerValues)
        binding.spinnerJobTitle.adapter = spinnerAdapter
    }

    private fun onPreviewClicked() {
        val contactName = binding.editTextContactName.text.toString()
        val contactNumber = binding.editTextContactNumber.text.toString()
        val myDisplayName = binding.editTextMyDisplayName.text.toString()
        val includeJunior: Boolean = binding.checkBoxJunior.isChecked
        val jobTitle = binding.spinnerJobTitle.selectedItem?.toString()
        val immediateStart = binding.checkBoxImmediatelyStart.isChecked
        val startDate = binding.editTextStartDate.text.toString()

        val message = Message(
            contactName = binding.editTextContactName.text.toString(),
            contactNumber = binding.editTextContactNumber.text.toString(),
            myDisplayName = binding.editTextMyDisplayName.text.toString(),
            includeJunior = binding.checkBoxJunior.isChecked,
            jobTitle = binding.spinnerJobTitle.selectedItem?.toString(),
            immediateStart = binding.checkBoxImmediatelyStart.isChecked,
            startDate = binding.editTextStartDate.text.toString()
        )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message", message)
        startActivity(previewActivityIntent)
    }
}
