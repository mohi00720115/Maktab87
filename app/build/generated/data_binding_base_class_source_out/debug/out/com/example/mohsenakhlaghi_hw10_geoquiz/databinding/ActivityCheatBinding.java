// Generated by data binding compiler. Do not edit!
package com.example.mohsenakhlaghi_hw10_geoquiz.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.mohsenakhlaghi_hw10_geoquiz.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityCheatBinding extends ViewDataBinding {
  @NonNull
  public final Button btnCheatActivity;

  @NonNull
  public final TextView tvCheat;

  protected ActivityCheatBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button btnCheatActivity, TextView tvCheat) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnCheatActivity = btnCheatActivity;
    this.tvCheat = tvCheat;
  }

  @NonNull
  public static ActivityCheatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_cheat, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCheatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityCheatBinding>inflateInternal(inflater, R.layout.activity_cheat, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityCheatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_cheat, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCheatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityCheatBinding>inflateInternal(inflater, R.layout.activity_cheat, null, false, component);
  }

  public static ActivityCheatBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityCheatBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityCheatBinding)bind(component, view, R.layout.activity_cheat);
  }
}
