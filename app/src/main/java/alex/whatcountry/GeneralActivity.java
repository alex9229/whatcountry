package alex.whatcountry;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import net.sourceforge.zbar.Config;
import net.sourceforge.zbar.ImageScanner;

public class GeneralActivity extends AppCompatActivity {
    ImageScanner scanner = new ImageScanner();
    private static final int ZBAR_SCANNER_REQUEST = 0;
    private static final int ZBAR_QR_SCANNER_REQUEST = 1;
    private CountryUtill countryUtill = new CountryUtill();
    /**
     * The Scanner.
     */
    static {
        System.loadLibrary("iconv");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO remove name from upside
        setContentView(R.layout.activity_general);
        scanner.setConfig(0, Config.X_DENSITY, 3);
        scanner.setConfig(0, Config.Y_DENSITY, 3);

        Intent intent = new Intent(this, ZBarScannerActivity.class);
                startActivityForResult(intent, ZBAR_SCANNER_REQUEST);

    }

    /**
     * return the result of scanning
     *
     * @return void
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case ZBAR_SCANNER_REQUEST:
            case ZBAR_QR_SCANNER_REQUEST:
                if (resultCode == this.RESULT_OK) {
                    if (checkCorrect(data.getStringExtra(ZBarConstants.SCAN_RESULT))) {
//                    System.out.println(data.getStringExtra());
                        alertDialogCreate(getString(R.string.Res), countryUtill.getCountry(data.getStringExtra(ZBarConstants.SCAN_RESULT)));
                    }else{negativeScan();}
                }else if (resultCode == this.RESULT_CANCELED && data != null) {
                    String error = data.getStringExtra(ZBarConstants.ERROR_INFO);
                    if (!TextUtils.isEmpty(error)) {
                        negativeScan();
                    }
                }
                break;
        }
    }

    /**
     * method for bad scan
     * Do scan if Rescan
     * @return void
     */
    private void negativeScan (){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.ScanFiled))
                .setCancelable(false)
                .setPositiveButton(getString(R.string.Rescan),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                final Intent intent = new Intent(getApplicationContext(), ZBarScannerActivity.class);
                                startActivityForResult(intent, ZBAR_SCANNER_REQUEST);
                            }
                        })
                .setNegativeButton(getString(R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                              System.exit(0);
                            }
                        });

        builder.create().show();

    }

    /**
     * method create alertdialog for succesfull dialog
     * @return void
     */
    public  void alertDialogCreate(String title, String message) {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton("Done",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                System.exit(0);
                            }
                        })
                .setPositiveButton("Scane more",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(getApplicationContext(), ZBarScannerActivity.class);
                                startActivityForResult(intent, ZBAR_SCANNER_REQUEST);
                            }
                        });
        AlertDialog aleDial = builder.create();
        aleDial.show();


    }

    private boolean checkCorrect(String Word){
        Integer part1;
        Integer part2;
        boolean res=false;
        if (Word.length()!=13){res=false; }
        else{ try {
            part1=Integer.parseInt(Word.substring(1,2))+Integer.parseInt(Word.substring(3,4))
                    +Integer.parseInt(Word.substring(5,6))+Integer.parseInt(Word.substring(7,8))
                    +Integer.parseInt(Word.substring(9,10))+Integer.parseInt(Word.substring(11,12));
            part2=Integer.parseInt(Word.substring(0,1))+Integer.parseInt(Word.substring(2,3))
                    +Integer.parseInt(Word.substring(4,5))+Integer.parseInt(Word.substring(6,7))
                    +Integer.parseInt(Word.substring(8,9))+Integer.parseInt(Word.substring(10,11));
            part1=part1*3+part2;
            Integer mode =10- Integer.parseInt(part1.toString().substring(1,2));
            if (mode.toString().equals(Word.substring(Word.length()-1))){
                res=true;
            }else{res=false;}
        }catch(Exception e){ return false;}
        }
        return res;
    }

}
