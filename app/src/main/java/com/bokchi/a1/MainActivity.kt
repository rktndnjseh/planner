package com.bokchi.a1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.app.AlertDialog
import android.app.TimePickerDialog
import android.widget.CalendarView
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAddTask: Button = findViewById(R.id.buttonAddTask)
        val buttonSave: Button = findViewById(R.id.buttonSave)
        val buttonDeleteTask: Button = findViewById(R.id.buttonDeleteTask)
        val buttonSetTime: Button = findViewById(R.id.buttonSetTime)
        val buttonWeather: Button = findViewById(R.id.buttonWeather)
        val buttonAppInfo: Button = findViewById(R.id.buttonAppInfo)
        val buttonSaveVacation: Button = findViewById(R.id.buttonSaveVacation)
        // CalendarView 타입으로 변경하고 findViewById를 사용하여 연결
        val calendarView: CalendarView = findViewById(R.id.calendarView)
//sdafasfdfasdfasdfdsa
        buttonAddTask.setOnClickListener {
            val taskEditText = EditText(this)
            AlertDialog.Builder(this)
                .setTitle("할일 입력")
                .setView(taskEditText)
                .setPositiveButton("확인") { dialog, which ->
                    val task = taskEditText.text.toString()
                    Toast.makeText(this, "할일: $task", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("취소", null)
                .create()
                .show()
        }

        buttonSetTime.setOnClickListener {
            val currentTime = Calendar.getInstance()
            val hour = currentTime.get(Calendar.HOUR_OF_DAY)
            val minute = currentTime.get(Calendar.MINUTE)
            TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                Toast.makeText(this, "선택한 시간: $selectedHour 시 $selectedMinute 분", Toast.LENGTH_SHORT).show()
            }, hour, minute, false).show()
        }

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            Toast.makeText(this, "선택한 날짜: $year 년 ${month + 1} 월 $dayOfMonth 일", Toast.LENGTH_SHORT).show()
        }

        // 나머지 버튼들에 대한 클릭 이벤트 리스너도 여기에 추가하세요.
    }
}
