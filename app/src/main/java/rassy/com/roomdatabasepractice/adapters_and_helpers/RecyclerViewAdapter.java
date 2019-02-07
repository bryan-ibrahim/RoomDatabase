package rassy.com.roomdatabasepractice.adapters_and_helpers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import rassy.com.roomdatabasepractice.R;
import rassy.com.roomdatabasepractice.room_db.UserEntity;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.UserViewHolder> {

    private List<UserEntity> userList;

    public RecyclerViewAdapter(List<UserEntity> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_user, null, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int position) {
        userViewHolder.tvId.setText(String.valueOf(userList.get(position).getId()));
        userViewHolder.tvFirstname.setText(userList.get(position).getFirstName());
        userViewHolder.tvLastName.setText(userList.get(position).getLastName());
        userViewHolder.tvEmail.setText(userList.get(position).getEmailAddress());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView tvId,tvFirstname, tvLastName, tvEmail;

        UserViewHolder(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tvId);
            tvFirstname = itemView.findViewById(R.id.tvFirstName);
            tvLastName = itemView.findViewById(R.id.tvLastName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }
}
