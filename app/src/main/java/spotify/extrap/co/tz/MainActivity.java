package spotify.extrap.co.tz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.splashscreen.SplashScreenViewProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Install splash screen before super.onCreate
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        // Set exit animation
        splashScreen.setOnExitAnimationListener((SplashScreenViewProvider provider) -> {
            View splashView = provider.getView();
            splashView.animate()
                    .alpha(0f)
                    .setDuration(300L)
                    .withEndAction(provider::remove)
                    .start();
        });

        Button signupBtn = findViewById(R.id.button_signup);
        Button loginBtn = findViewById(R.id.button_login);

        signupBtn.setOnClickListener(v -> {
            Intent signupIntent = new Intent(MainActivity.this, SignupActivity.class);
            startActivity(signupIntent);
        });

        loginBtn.setOnClickListener(v -> {
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginIntent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}