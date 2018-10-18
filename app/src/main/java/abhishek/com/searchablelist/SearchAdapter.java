package abhishek.com.searchablelist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhishek on 10/18/2018.
 */

public class SearchAdapter extends RecyclerView.Adapter<ViewHold> implements Filterable {

    List<User> userList;
    List<User> userListFiltered;

    SearchAdapter(List<User> userList) {
        this.userList = userList;
        this.userListFiltered = userList;

    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    userListFiltered = userList;
                } else {
                    List<User> filteredList = new ArrayList<>();
                    for (User row : userList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match

//                        String price = String.valueOf(row.getPrice());

                        if (row.getPrice().toLowerCase().contains(charSequence) || row.getName().toLowerCase().contains(charSequence)|| row.getName().toUpperCase().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    userListFiltered = filteredList;
                }


                FilterResults filterResults = new FilterResults();
                filterResults.values = userListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                userListFiltered = (ArrayList<User>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    @Override
    public ViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHold(view);

    }

    @Override
    public void onBindViewHolder(ViewHold holder, int position) {

        User user = userListFiltered.get(position);
        holder.price.setText(user.getPrice() + "");
        holder.name.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return userListFiltered.size();
    }
}
