package com.example.async_task

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val TAG = "THREAD_EXECUTION"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Async Task
        // Help to perform long running operation
        // That too in background without interacting with mainthread.

        Thread(
            object :Runnable{
                override fun run() {

                    for (i in 1..10){
                        Log.d(TAG, i.toString())
                    }

                }
            }
        ).start()

        Simple_AsyncTask().execute()

    }




}


class  Simple_AsyncTask : AsyncTask<String, Int, String>(){


    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
    }

    override fun doInBackground(vararg p0: String?): String {
        for (i in 1..10){
            Thread.sleep(1000)
            Log.d("ASYNC_THREAD_EXECUTION", i.toString())
        }
        return  "Finished"
    }

    override fun onPostExecute(result: String?) {
        Log.d("Completed", "Task Executed !!!")
     }

}