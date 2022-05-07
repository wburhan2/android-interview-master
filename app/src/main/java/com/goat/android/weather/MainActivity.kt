package com.goat.android.weather

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.goat.android.weather.databinding.ActivityMainBinding
import java.util.jar.Manifest

const val LOCATION_REQUEST = 12312

class MainActivity : AppCompatActivity() {

  lateinit var locationManager: LocationManager
  lateinit var location: Location
  lateinit var vm: WeatherViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding =  DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

    vm = ViewModelProvider(this).get(WeatherViewModel::class.java)
    binding.lifecycleOwner = this
    binding.vm = vm

    if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
      getLocationData()
    } else {
      requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_REQUEST)
    }
  }

  @SuppressLint("MissingPermission")
  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    if (requestCode == LOCATION_REQUEST) {
      getLocationData()
    }
  }

  @SuppressLint("MissingPermission")
  private fun getLocationData() {
    locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
//    location = locationManager.getLastKnownLocation(locationManager.getBestProvider(Criteria(), true)!!)!!
//    if (location == null) {
      vm.getWeatherData(34.0522, 118.2437, getString(R.string.api_key))
//    }

  }
}