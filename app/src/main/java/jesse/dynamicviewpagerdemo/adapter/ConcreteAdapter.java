package jesse.dynamicviewpagerdemo.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

import jesse.dynamicviewpagerdemo.FruitFragment;
import jesse.dynamicviewpagerdemo.entity.FruitEntity;

/**
 * Created by JesseFu on 2019/2/20.
 */

public class ConcreteAdapter extends DynamicFragmentStatePagerAdapter<FruitEntity> {
    private static final String TAG = "ConcreteAdapter";

    private List<FruitEntity> mData;

    public ConcreteAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setData(List<FruitEntity> data){
        mData = data;
        notifyDataSetChanged();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
//        return super.getPageTitle(position);
        return mData.get(position).getName();
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        FruitEntity entity = getItemData(position);
        FruitFragment fragment = FruitFragment.newInstance(entity);
        return fragment;
    }

    @Override
    public FruitEntity getItemData(int position) {
        if (position >= mData.size()) return null;

        return mData == null ? null : mData.get(position);
    }

    @Override
    public boolean dataEquals(FruitEntity oldData, FruitEntity newData) {
        if (oldData == null || newData == null) return false;

        return oldData.getName() == newData.getName();
    }

    /**
     * @param data
     * @return <0  表示该数据已经不存在了，就是说被删除了....
     */
    @Override
    public int getDataPosition(FruitEntity data) {
        int index = -1;
        for (int i = 0;i < mData.size();i++){
            FruitEntity item = mData.get(i);
            if (dataEquals(item,data)){
                index = i;
                break;
            }
        }
        return index;

    }

    @Override
    public int getCount() {
        int count = mData == null ? 0 : mData.size();
        return count;
    }
}
