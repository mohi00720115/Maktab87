package com.example.mohsenakhlaghi_hw10_geoquiz

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class GameFragmentDirections private constructor() {
  public companion object {
    public fun actionGameFragmentToCheatFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_gameFragment_to_cheatFragment)
  }
}
