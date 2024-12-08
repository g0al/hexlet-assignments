package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {
        private String text;
        private List<Tag> tags;

        PairedTag(String name, Map<String, String> attr, String text, List<Tag> tags) {
                super(name, attr);
                this.text = text;
                this.tags = new ArrayList<>(tags) {
                        @Override
                        public String toString() {
                                StringBuilder sb = new StringBuilder();
                                tags.forEach(sb::append);
                                return sb.toString().trim();
                        }
                };
        }

        @Override
        public String toString() {
                if (attr.isEmpty()) {
                        return String.format(
                                "<%s></%s>", name, name
                        );
                }
                return String.format(
                        "<%s %s>%s%s</%s>",
                        name, attr, text, tags, name
                );
        }
}
// END
