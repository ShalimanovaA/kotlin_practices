package com.angi_sh.secondapp

import android.content.pm.PackageManager
import android.hardware.Camera
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.angi_sh.secondapp.databinding.FragmentUseCameraBinding
import java.io.File
import java.time.LocalDateTime


class UseCamera : Fragment(),  SurfaceHolder.Callback {
    private lateinit var camera: Camera
    private lateinit var surfaceHolder: SurfaceHolder
    private lateinit var binding: FragmentUseCameraBinding
    private lateinit var surfaceView0: SurfaceView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUseCameraBinding.inflate(inflater, container,
            false)


        // Inflate the layout for this fragment
        if (checkCameraPermission()) {
            camera = Camera.open()
            surfaceView0 = binding.surfaceView
            surfaceHolder = surfaceView0.holder
            surfaceHolder.addCallback(this)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {

            val photosDirectory = File(requireContext().externalMediaDirs.first(), "photos")

            if (!photosDirectory.exists()) {
                photosDirectory.mkdir()
            }

            val dateFile = File(photosDirectory, "date.txt")

            if (!dateFile.exists()) {
                dateFile.createNewFile()
            }
            dateFile.appendText("\n"+LocalDateTime.now().toString())
        }
        binding.toList.setOnClickListener{
            findNavController().navigate(R.id.action_useCamera_to_listView)
        }
    }

        private fun checkCameraPermission(): Boolean {
        return if (
            requireActivity().checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
        ) {
            true
        } else {
            requestPermissions(arrayOf(android.Manifest.permission.CAMERA), 1)
            false
        }
    }


    override fun surfaceCreated(holder: SurfaceHolder) {
        try {
            // Подключаем предпросмотр к SurfaceView
            camera.setPreviewDisplay(holder)
            camera.startPreview()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        // Освобождаем ресурсы камеры
        camera.stopPreview()
        camera.release()
    }
}