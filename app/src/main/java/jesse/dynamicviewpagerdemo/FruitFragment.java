package jesse.dynamicviewpagerdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jesse.dynamicviewpagerdemo.entity.FruitEntity;

/**
 * Created by JesseFu on 2019/2/20.
 */

public class FruitFragment extends Fragment {
    private static final String TAG = "FruitFragment";

    private static final String KEY = "key";
    public static FruitFragment newInstance(FruitEntity entity){
        FruitFragment fruitFragment = new FruitFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY, entity);
        fruitFragment.setArguments(bundle);
        return fruitFragment;
    }

    private View mRoot;
    private TextView mTvFruit;

    private FruitEntity entity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.frag_fruit, container, false);
        mTvFruit = mRoot.findViewById(R.id.tv_frag_fruit);
        entity = getArguments().getParcelable(KEY);
        mTvFruit.setText(entity.getName());
        return mRoot;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
