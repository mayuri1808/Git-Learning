package package_navigationdrawer;

import java.util.ArrayList;
import java.util.List;

public class Articles {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Articles1> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles1> articles) {
        this.articles = articles;
    }

    private List<Articles1> articles = new ArrayList<>();

    public class Articles1{
        private String author;
        private String title;
        private String description;
        private String url;
        private String publishedAt;
        private String content;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
