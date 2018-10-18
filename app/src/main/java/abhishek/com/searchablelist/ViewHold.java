package abhishek.com.searchablelist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Abhishek on 10/18/2018.
 */

public class ViewHold extends RecyclerView.ViewHolder {


    public TextView name;
    public TextView price;

    public ViewHold(View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        price = itemView.findViewById(R.id.price);
    }
}
