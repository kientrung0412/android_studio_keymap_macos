#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

#set($model_name = ${StringUtils.removeAndHump(${Model}, ".")})
#set($first_letter_lower = $model_name.substring(0,1).toLowerCase())
#set($first_letter_upper = $model_name.substring(0,1).toUpperCase())
#set($the_rest = $model_name.substring(1))
#set($model_name = $first_letter_lower + $the_rest)
#set($class_model = $first_letter_upper + $the_rest)

#set( $class_name = ${NAME} +"Adapter")

#set( $root_path = ${PACKAGE_NAME})
#set( $last_index =  $root_path.lastIndexOf(".") )
#set( $root_path = $root_path.substring(0,$last_index))

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import $root_path .models. $class_model;
import $root_path .R;


import java.util.ArrayList;

public class $class_name extends RecyclerView.Adapter< $class_name .Holder${NAME}> {

    private LayoutInflater layoutInflater;
    private ArrayList<$class_model> data;
    private OnClick${NAME}Listener listener;

    public $class_name(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public void setListener(OnClick${NAME}Listener listener) {
        this.listener = listener;
    }

    public void setData(ArrayList<$class_model> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder${NAME} onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(, parent, false);
        return new Holder${NAME}(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder${NAME} holder, int position) {
        final $class_model $model_name  = data.get(position);
        holder.bindView($model_name);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }


    public class Holder${NAME} extends RecyclerView.ViewHolder {

        private $class_model $model_name; 

        public Holder${NAME}(@NonNull View itemView) {
            super(itemView);
            if($model_name != null){
                itemView.setOnClickListener($model_name ->
                    {
                    }
                );
            }
        }

        private void bindView($class_model $model_name) {
           this.$model_name = $model_name;
        }
    }

    public interface OnClick${NAME}Listener {
        void onClick${NAME}($class_model $model_name);
        void onClickLong${NAME}($class_model $model_name);
    }

}
