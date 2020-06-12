package component;

import org.springframework.beans.propertyeditors.CustomCollectionEditor;

/**
 * @Author Yan
 * @Description
 * @Date 2020/6/11 11:11 下午
 */
public class FactoryListEditor extends CustomCollectionEditor {
    public FactoryListEditor() {
        super(FactoryArrayList.class);
    }
}
