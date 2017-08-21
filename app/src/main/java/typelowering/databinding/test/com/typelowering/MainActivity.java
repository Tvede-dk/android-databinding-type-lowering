package typelowering.databinding.test.com.typelowering;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import typelowering.databinding.test.com.typelowering.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding inflate = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(inflate.getRoot());

        //overview:
        // - mainLayout should be LinearLayout (as they are the same type, linear layout).
        // - failing1 should be "ViewGroup" (common base of RelativeLayout and TableLayout)
        // - failing2 should be "RelativeLayout" (common base of RelativeLayout and MyRelativeLayout)
        // - failing3 should be "View" (common base of View and FrameLayout)
        // - failing4 same as failing3

        testViewGroup(inflate.failing1); //fails,
        testViewGroup(inflate.failing2); //fails
        testViewGroup(inflate.mainLayout);

        testRelativeLayout(inflate.failing1); //fails
        testRelativeLayout(inflate.failing2); // fails


        //the following should be marked red / unable to compile: (it isn't)
        testViewGroup(inflate.failing3);

        //however it works for failing4 which is the reverse case.
        testViewGroup(inflate.failing4);
    }

    private void testViewGroup(ViewGroup vg) {

    }

    private void testRelativeLayout(RelativeLayout vg) {

    }
}
