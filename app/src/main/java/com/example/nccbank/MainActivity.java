package com.example.nccbank;

import androidx.appcompat.app.AppCompatActivity;
import com.example.nccbank.databinding.ActivityMainBinding;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.nccbank.AccountFragment;
import com.example.nccbank.TransferFragment;
import com.example.nccbank.WithdrawFragment;
import com.example.nccbank.DepositFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        user = getIntent().getParcelableExtra("user");
        Bundle args = new Bundle();
        args.putParcelable("user", user);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            // Removed the inner declaration of args
            switch (item.getItemId()){
                case R.id.accounts:
                    replaceFragment(AccountFragment.newInstance(args));
                    break;
                case R.id.transfer:
                    replaceFragment(TransferFragment.newInstance(args));
                    break;
                case R.id.withdraw:
                    replaceFragment(WithdrawFragment.newInstance(args));
                    break;
                case R.id.deposit:
                    replaceFragment(DepositFragment.newInstance(args));
                    break;
            }
            return true;
        });

        replaceFragment(AccountFragment.newInstance(args));
    }




    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
