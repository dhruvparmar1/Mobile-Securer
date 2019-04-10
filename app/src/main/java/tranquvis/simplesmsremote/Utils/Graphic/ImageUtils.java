package tranquvis.simplesmsremote.Utils.Graphic;

import android.graphics.Bitmap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.nio.ByteBuffer;


public class ImageUtils {

    /**
     * Retrieve Bitmap with specific format from ImageReader.
     *
     * @param imageReader the image reader
     * @return bitmap
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static Bitmap GetBitmapFromImageReader(ImageReader imageReader) {
        Bitmap bitmap;

        //get image buffer
        Image image = imageReader.acquireLatestImage();
        final Image.Plane[] planes = image.getPlanes();
        final ByteBuffer buffer = planes[0].getBuffer();

        int pixelStride = planes[0].getPixelStride();
        int rowStride = planes[0].getRowStride();
        int rowPadding = rowStride - pixelStride * image.getWidth();
        // create bitmap
        bitmap = Bitmap.createBitmap(image.getWidth() + rowPadding / pixelStride, image.getHeight(), Bitmap.Config.ARGB_8888);
        bitmap.copyPixelsFromBuffer(buffer);
        image.close();
        return bitmap;
    }
}
