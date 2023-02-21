package com.example.mohsenakhlaghi_hw10_geoquiz;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.mohsenakhlaghi_hw10_geoquiz.databinding.ActivityCheatBindingImpl;
import com.example.mohsenakhlaghi_hw10_geoquiz.databinding.ActivityMainBindingImpl;
import com.example.mohsenakhlaghi_hw10_geoquiz.databinding.FragmentFirstBindingImpl;
import com.example.mohsenakhlaghi_hw10_geoquiz.databinding.FragmentSecondBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYCHEAT = 1;

  private static final int LAYOUT_ACTIVITYMAIN = 2;

  private static final int LAYOUT_FRAGMENTFIRST = 3;

  private static final int LAYOUT_FRAGMENTSECOND = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mohsenakhlaghi_hw10_geoquiz.R.layout.activity_cheat, LAYOUT_ACTIVITYCHEAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mohsenakhlaghi_hw10_geoquiz.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mohsenakhlaghi_hw10_geoquiz.R.layout.fragment_first, LAYOUT_FRAGMENTFIRST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mohsenakhlaghi_hw10_geoquiz.R.layout.fragment_second, LAYOUT_FRAGMENTSECOND);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYCHEAT: {
          if ("layout/activity_cheat_0".equals(tag)) {
            return new ActivityCheatBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_cheat is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFIRST: {
          if ("layout/fragment_first_0".equals(tag)) {
            return new FragmentFirstBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_first is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSECOND: {
          if ("layout/fragment_second_0".equals(tag)) {
            return new FragmentSecondBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_second is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "viewModel1");
      sKeys.put(2, "viewModel2");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/activity_cheat_0", com.example.mohsenakhlaghi_hw10_geoquiz.R.layout.activity_cheat);
      sKeys.put("layout/activity_main_0", com.example.mohsenakhlaghi_hw10_geoquiz.R.layout.activity_main);
      sKeys.put("layout/fragment_first_0", com.example.mohsenakhlaghi_hw10_geoquiz.R.layout.fragment_first);
      sKeys.put("layout/fragment_second_0", com.example.mohsenakhlaghi_hw10_geoquiz.R.layout.fragment_second);
    }
  }
}
