package tranquvis.simplesmsremote.Data;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;

import java.io.File;
import java.io.Serializable;


public class CaptureSettings implements Serializable, Cloneable {
    private String cameraId = null;
    private int[] resolution; // width, height
    private ImageFormat outputImageFormat = ImageFormat.JPEG;
    private String outputPath;
    private boolean autofocus = true;
    private FlashlightMode flashlight = FlashlightMode.AUTO;

    public CaptureSettings(@Nullable String cameraId, int[] resolution, ImageFormat outputImageFormat,
                           String outputPath) {
        this.cameraId = cameraId;
        this.resolution = resolution;
        this.outputImageFormat = outputImageFormat;
        this.outputPath = outputPath;
    }

    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId;
    }

    public int[] getResolution() {
        return resolution;
    }

    public void setResolution(int[] resolution) {
        this.resolution = resolution;
    }

    public ImageFormat getOutputImageFormat() {
        return outputImageFormat;
    }

    public void setOutputImageFormat(ImageFormat outputImageFormat) {
        this.outputImageFormat = outputImageFormat;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public String getFileOutputPath() {
        String filename = "remotely_" + String.valueOf(System.currentTimeMillis()) + "."
                + outputImageFormat.getFileExtension();
        return outputPath + File.separator + filename;
    }

    public boolean isAutofocus() {
        return autofocus;
    }

    public void setAutofocus(boolean autofocus) {
        this.autofocus = autofocus;
    }

    public FlashlightMode getFlashlight() {
        return flashlight;
    }

    public void setFlashlight(FlashlightMode flashlight) {
        this.flashlight = flashlight;
    }

    public CaptureSettings clone() throws CloneNotSupportedException {
        return (CaptureSettings) super.clone();
    }

    public enum FlashlightMode {
        AUTO, ON, OFF
    }

    public enum ImageFormat {
        JPEG(Bitmap.CompressFormat.JPEG, "jpg");

        private Bitmap.CompressFormat bitmapCompressFormat;
        private String fileExtension;

        ImageFormat(Bitmap.CompressFormat bitmapCompressFormat, String fileExtension) {
            this.bitmapCompressFormat = bitmapCompressFormat;
            this.fileExtension = fileExtension;
        }

        public Bitmap.CompressFormat getBitmapCompressFormat() {
            return bitmapCompressFormat;
        }

        public String getFileExtension() {
            return fileExtension;
        }
    }
}
