import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import com.example.memorydemo.R;

public class SimpleMenu extends Activity {
    private static final String TAG = "SimpleMenu";
    @Override
    protected void onCreate(Bundle onSavedInstance) {
        super.onCreate(onSavedInstance);
        setContentView(R.layout.simple_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 添加一个 id 为 0，顺序为 0 的“关于”菜单
        menu.add(0, 0, 0, "About");

        // 添加一个 id 为 1，顺序为 1 的“退出”菜单
        menu.add(0, 1, 1, "Exit");
        Log.i(TAG, "call onCreateOptionsMenu");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case 0:
                showDialog();
                break;

            case 1:
                showExitDialog();
                break;

            default:

        }
        return true;
    }

    private void showDialog() {
        new AlertDialog.Builder(this)
                .setTitle("About")
                .setMessage("This is just a demo.")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    private void showExitDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure to EXIT?")
                .setPositiveButton("Sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }
}
