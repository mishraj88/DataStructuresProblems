import java.util.*;

class UniqueImages {
    public static class Image {
        private String filename;
        private int width;
        private int height;
        public Image(String filename, int width, int height) {
            this.filename = filename;
            this.width = width;
            this.height = height;
        }


        /**
         The Set will call out the equals method if it receives the same hash(hashCode(ImageObjects))
         Since we have established equality of two image objects on their name basis and height*width
         We have to incorporate that as well in our hashCode(), which was not implemented earlier.
         */
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            StringTokenizer st = new StringTokenizer(this.filename, ".");
            String name = st.nextToken();
            result = prime * result
                    + ((name == null) ? 0 : name.hashCode());
            result = prime * result + height*width;

            return result;
        }


        /**
         * Two Images are considered equal if they have
         * the same filename (without the extension), and the
         * same number of pixels.
         * Thus, flag.jpg with width=60 height=40 is
         * equal to flag.gif with width=40 and height=60
         */
        public boolean equals(Object other) {

            Image o = (Image)other;
            if (this.filename == null || o.filename == null)
                return false;
            String[] components = this.filename.split("\\.");
            String[] ocomponents = o.filename.split("\\.");

            return components[0].equals(ocomponents[0]) &&
                    width * height == o.width * o.height;
        }

        public String toString() {
            return "Image: filename=" + filename + " Size=" + width*height;
        }
    }

    public static void printImages(Set<Image> images) {
        for(Image image: images) {
            System.out.println(image);
        }
    }

    public static void main(String[] args) {
        Image[] images = {new Image("flag.jpg", 40, 60),
                new Image("flag.gif", 40, 60),
                new Image("smile.gif", 100, 200),
                new Image("smile.gif", 50, 400),
                new Image("other.jpg", 40, 60),
                new Image("lenna.jpg", 512, 512),
                new Image("Lenna.jpg", 512, 512)};
        Set<Image> set = new HashSet<Image>(Arrays.asList(images));

        UniqueImages.printImages(set);
    }
}