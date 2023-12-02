package esteban.g.twitter_searchesapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class SearchesAdapter extends RecyclerView.Adapter<SearchesAdapter.ViewHolder>{
    private final View.OnClickListener clickListener;
    private final View.OnLongClickListener longClickListener;
    private final List<String> tags;

    public SearchesAdapter(List<String> tags, View.OnClickListener clickListener,
                           View.OnLongClickListener longClickListener) {
         this.tags = tags;
         this.clickListener = clickListener;
         this.longClickListener = longClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public final TextView textView;
        public ViewHolder(View itemView, View.OnClickListener clickListener,
                          View.OnLongClickListener longClickListener) {
             super(itemView);
             textView = (TextView) itemView.findViewById(R.id.textView);

             // attach listeners to itemView
             itemView.setOnClickListener(clickListener);
             itemView.setOnLongClickListener(longClickListener);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                 R.layout.list_item, parent, false);
        return (new ViewHolder(view, clickListener, longClickListener));
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        holder.textView.setText(tags.get(position));
    }
    @Override
    public int getItemCount(){
        return tags.size();
    }
}
