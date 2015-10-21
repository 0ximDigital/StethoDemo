package stetho.five.stethodemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import stetho.five.stethodemo.R;
import stetho.five.stethodemo.business.dao.model.Variable;

public final class VariableItemAdapter extends ArrayAdapter<Variable> {

    public VariableItemAdapter(Context context) {
        super(context, R.layout.variable_list_item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.variable_list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.fillView(getItem(position));

        return convertView;
    }

    final class ViewHolder {

        @Bind(R.id.variable_name_text)
        TextView variableName;

        @Bind(R.id.variable_value_text)
        TextView varaibleValue;

        @Bind(R.id.variable_random_text)
                TextView variableRandom;

        ViewHolder(View view){
            ButterKnife.bind(this, view);
        }

        public void fillView(Variable variable){
            variableName.setText(variable.getName());
            varaibleValue.setText(String.valueOf(variable.getValue()));
            variableRandom.setText(String.valueOf(variable.getRandomValue()));
        }

    }
}
