package com.example.mohsenakhlaghi_hw10_geoquiz.databinding;
import com.example.mohsenakhlaghi_hw10_geoquiz.R;
import com.example.mohsenakhlaghi_hw10_geoquiz.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentGameBindingImpl extends FragmentGameBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.btn_next, 2);
        sViewsWithIds.put(R.id.btn_prev, 3);
        sViewsWithIds.put(R.id.btn_cheat, 4);
        sViewsWithIds.put(R.id.btn_false, 5);
        sViewsWithIds.put(R.id.btn_true, 6);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentGameBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private FragmentGameBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.Button) bindings[4]
            , (android.widget.Button) bindings[5]
            , (android.widget.Button) bindings[2]
            , (android.widget.Button) bindings[3]
            , (android.widget.Button) bindings[6]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvQuiz.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel1 == variableId) {
            setViewModel1((com.example.mohsenakhlaghi_hw10_geoquiz.GameViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel1(@Nullable com.example.mohsenakhlaghi_hw10_geoquiz.GameViewModel ViewModel1) {
        this.mViewModel1 = ViewModel1;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewModel1);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModel1Str1((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModel1Str1(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModel1Str1, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String viewModel1Str1ToString = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModel1Str1 = null;
        java.lang.String viewModel1Str1GetValue = null;
        com.example.mohsenakhlaghi_hw10_geoquiz.GameViewModel viewModel1 = mViewModel1;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel1 != null) {
                    // read viewModel1.str1
                    viewModel1Str1 = viewModel1.getStr1();
                }
                updateLiveDataRegistration(0, viewModel1Str1);


                if (viewModel1Str1 != null) {
                    // read viewModel1.str1.getValue()
                    viewModel1Str1GetValue = viewModel1Str1.getValue();
                }


                if (viewModel1Str1GetValue != null) {
                    // read viewModel1.str1.getValue().toString()
                    viewModel1Str1ToString = viewModel1Str1GetValue.toString();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvQuiz, viewModel1Str1ToString);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel1.str1
        flag 1 (0x2L): viewModel1
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}