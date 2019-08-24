public class Button {
    onClickListener onClickListener;

    public void setOnClickListener(onClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void click(){
        onClickListener.onClick(this);
    }
}
