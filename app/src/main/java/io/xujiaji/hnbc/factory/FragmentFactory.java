package io.xujiaji.hnbc.factory;

import java.util.HashMap;
import java.util.Map;

import io.xujiaji.hnbc.config.C;
import io.xujiaji.hnbc.fragments.BaseMainFragment;
import io.xujiaji.hnbc.fragments.EditUserInfoFragment;
import io.xujiaji.hnbc.fragments.LoginFragment;
import io.xujiaji.hnbc.fragments.MainFragment;
import io.xujiaji.hnbc.fragments.RegisterFragment;
import io.xujiaji.hnbc.fragments.UserInfoFragment;
import io.xujiaji.hnbc.utils.LogUtil;

/**
 * Created by jiana on 16-11-6.
 */

public class FragmentFactory {
    /**
     * 主页Fragment数量
     */
    private static final int FRAGMENT_NUM = 8;

    /**
     * 统一管理MainActivity中所有Fragment
     */
    public static final Map<String, BaseMainFragment> MAIN_WIND_FRAG = new HashMap<>(FRAGMENT_NUM);

    /**
     * 在主页展示的Fragment工厂
     * @param key
     * @return
     */
    public static BaseMainFragment newFragment(String key) {
        BaseMainFragment newFragment = null;
        switch (key) {
            case C.fragment.HOME:
                newFragment = MainFragment.newInstance();
                break;
            case C.fragment.LOGIN:
                newFragment = LoginFragment.newInstance();
                break;
            case C.fragment.REGISTER:
                newFragment = RegisterFragment.newInstance();
                break;
            case C.fragment.USER_INFO:
                newFragment = UserInfoFragment.newInstance();
                break;
            case C.fragment.EDIT_USER_INFO:
                newFragment = EditUserInfoFragment.newInstance();
                break;
            default:
                break;
        }
        MAIN_WIND_FRAG.put(key, newFragment);
        return newFragment;
    }

    /**
     * 通过首页菜单下标获取对应Fragment的名字
     * @param index
     * @return
     */
    public static String menuName(int index) {
        switch (index) {
            case 0:
                return C.fragment.HOME;
            case 1:
                return C.fragment.USER_INFO + C.fragment.LOGIN + C.fragment.REGISTER;
            case 2:
                return C.fragment.COLLECT;
            case 3:
                return C.fragment.RELEASE;
            case 4:
                return C.fragment.SET;
            default:
                return "";
        }
    }

    /**
     * 获取MAIN_WIND_FRAG已经存在的Fragment
     * @param key
     * @return
     */
    public static BaseMainFragment getFrag(String key) {
        return MAIN_WIND_FRAG.get(key);
    }

    /**
     * 获取MAIN_WIND_FRAG中对应的Fragment，如果没有则创建
     * @param key
     * @return
     */
    public static BaseMainFragment getOrCreate(String key) {
        BaseMainFragment baseMainFragment = MAIN_WIND_FRAG.get(key);
        if (baseMainFragment == null) {
            LogUtil.e3("通过" + key + "没有获取到对应Fragment，将会创建一个新的");
            baseMainFragment = newFragment(key);
        }
        return baseMainFragment;
    }

    /**
     * 将MAIN_WIND_FRAG对应key的value删除
     * @param key
     */
    public static void rmFrag(String key) {
        MAIN_WIND_FRAG.remove(key);
        LogUtil.e3("remove key = " + key + "; value = " + MAIN_WIND_FRAG.get(key));
    }

    /**
     * 更新头像
     */
    public static void updatedHeadPic() {
        for (String key : MAIN_WIND_FRAG.keySet()) {
            BaseMainFragment fragment = MAIN_WIND_FRAG.get(key);
            if (fragment == null) continue;
            fragment.setUpdatedHeadPic(true);
        }
    }
}
