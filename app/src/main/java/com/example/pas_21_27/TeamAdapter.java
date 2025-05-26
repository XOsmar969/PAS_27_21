package com.example.pas_21_27;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private List<Team> teamList;

    public TeamAdapter(List<Team> teams) {
        this.teamList = teams;
    }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TeamViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.tvTeamName.setText(team.getStrTeam());

        if (team.getStrTeamBadge() != null && !team.getStrTeamBadge().isEmpty()) {
            Picasso.get()
                    .load(team.getStrTeamBadge())
                    .into(holder.ivTeamBadge);
        } else {
            holder.ivTeamBadge.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {

        TextView tvTeamName;
        ImageView ivTeamBadge;

        public TeamViewHolder(View itemView) {
            super(itemView);
            tvTeamName = itemView.findViewById(R.id.tvTeamName);
            ivTeamBadge = itemView.findViewById(R.id.ivTeamBadge);
        }
    }
}
